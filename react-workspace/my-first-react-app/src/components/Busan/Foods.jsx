import {
  StyledCard,
  StyledImg,
  StyledInnerWrap,
  StyledMoreButton,
  StyledStoreName,
  StyledTitle,
  StyledWrap,
} from "./Foods.styles";

import { useNavigate } from "react-router-dom";

import { useEffect, useState } from "react";
import axios from "axios";

const Foods = () => {
  // 무슨 코드를 작성해야하나요? => 스프링서버로 요청을 보내는 코드
  const [pageNo, setPageNo] = useState(1);
  const [hasMore, sethasMore] = useState(true); // 식당이 더 있는가 없는가
  const [foods, setFoods] = useState([]);
  const navi = useNavigate();

  useEffect(() => {
    /*fetch("http://localhost/spring/api/busan?pageNo=1")
      .then((response) => response.json())
      .then((data) => console.log(data))
      .catch((err) => console.log("문제발생 삐용삐용", err))
      .finally(console.log("얘는 무조건함"));
      */
    // axios({
    //   url: "http://localhost/spring/api/busan?pageNo=1",
    //   method: "get",
    // }).then((result) => console.log(result));
    axios
      .get(`http://localhost/spring/api/busan?pageNo=${pageNo}`)
      .then((result) => {
        //console.log(result);

        const response = result.data.getFoodKr.item;
        setFoods([...foods, ...response]);

        //console.log(response);
        if (response.length < 6) {
          sethasMore(false);
        }
      });
  }, [pageNo]);

  const buttonHandler = () => {
    setPageNo((pageNo) => pageNo + 1);
  };

  return (
    <>
      <StyledWrap>
        <StyledTitle>부산의 맛집 알아보기</StyledTitle>
        <StyledInnerWrap>
          {foods.length === 0 ? (
            <div>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
              <StyledCard></StyledCard>
            </div>
          ) : (
            foods.map((e) => {
              return (
                <StyledCard
                  key={e.MAIN_TITLE}
                  onClick={() => navi(`/foods/${e.UC_SEQ}`)}
                >
                  <StyledImg src={e.MAIN_IMG_THUMB} />
                  <br />
                  <StyledStoreName>{e.MAIN_TITLE}</StyledStoreName>
                </StyledCard>
              );
            })
          )}
        </StyledInnerWrap>
        {hasMore && (
          <StyledMoreButton onClick={buttonHandler}>
            더보기 버튼
          </StyledMoreButton>
        )}
      </StyledWrap>
    </>
  );
};

export default Foods;

import { useState, useEffect } from "react";
import axios from "axios";

const Comments = (props) => {
  const [comments, setComments] = useState([]);
  //console.log(`상위컴포넌트가 넘겨준 : ${props.id}`);

  // 오늘의 숙제 : 미니프로젝트에서 사용할 OpenAPI 하나 찾아오기
  //              + API문서 정독하고오기

  const id = props.id;
  useEffect(() => {
    // 전체 후기를 싹다 조회할 예정이 아님
    axios.get(`http://localhost/spring/api/comments/${id}`).then((result) => {
      //console.log(result);
      setComments([...result.data]);
    });
  }, [props.success, id]);

  return (
    <>
      {comments.length != 0 ? (
        comments.map((e) => {
          return (
            <div style={{ width: "1100px", margin: "auto" }} key={e.content}>
              <h4>{e.content}</h4>
              <h5>{e.createDate}</h5>
            </div>
          );
        })
      ) : (
        <h2>아직 댓글이 존재하지 않습니다.</h2>
      )}
    </>
  );
};

export default Comments;

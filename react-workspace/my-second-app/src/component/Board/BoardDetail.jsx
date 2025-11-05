import { useParams, useNavigate } from "react-router-dom";
import axios from "axios";
import { useState, useEffect, useContext } from "react";
import {
  Container,
  ImageContainer,
  ImagePreview,
  Title,
  BoardWriter,
  BoardContent,
  Form,
  Button,
} from "../styles/Styles";
import { AuthContext } from "../context/AuthContext";
import CommentForm from "../Comment/CommentForm";

const BoardDetail = () => {
  const { id } = useParams();
  const navi = useNavigate();
  const [board, setBoard] = useState(null);
  const [load, isLoad] = useState(false);
  const [msg, setMsg] = useState("");
  const { auth } = useContext(AuthContext);

  //  alert(`모범시민 특 ${id}`);

  useEffect(() => {
    axios
      .get(`http://localhost:8081/boards/${id}`)
      .then((result) => {
        console.log(result);
        console.log(result.data);
        setBoard(result.data);
        isLoad(true);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [id]);

  const handleDelete = (e) => {
    e.preventDefault();
    if (confirm("진짜지울거임??")) {
      axios
        .delete(`http://localhost:8081/boards/${id}`, {
          headers: {
            Authorization: `Bearer ${auth.accessToken}`,
          },
        })
        .then(() => {
          setBoard({
            boardTitle: "삭제중입니다...",
            boardContent: "삭제중입니다...",
            boardWriter: "삭제중입니다...",
          });
          setTimeout(() => {
            navi("/boards");
          }, 5000);
        });
    }
  };

  return (
    <>
      {!load ? (
        <Container>
          <Title style={{ width: "50%", margin: "auto", lineHeight: "640xps" }}>
            게시글을 불러오는 중입니다......
          </Title>
        </Container>
      ) : (
        <Container>
          <Title>{board.boardTitle}</Title>
          <BoardWriter>작성자 : {board.boardWriter}</BoardWriter>
          <BoardContent>{board.boardContent}</BoardContent>
          {board.fileUrl ? (
            <ImageContainer>
              <ImagePreview src={board.fileUrl} alt="첨부파일" />
            </ImageContainer>
          ) : (
            <ImageContainer>님 이미지 없으심</ImageContainer>
          )}
          <Form onSubmit={handleDelete}>
            {board.boardWriter === auth.memberId && (
              <>
                <Button style={{ backgroundColor: "green" }} type="button">
                  수정하기인척
                </Button>
                <Button style={{ backgroundColor: "crimson" }}>삭제하기</Button>
              </>
            )}
          </Form>
        </Container>
      )}
      <CommentForm boardNo={id} />
    </>
  );
};

export default BoardDetail;

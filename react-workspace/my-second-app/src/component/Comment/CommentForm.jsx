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
  Input,
} from "../styles/Styles";
import { AuthContext } from "../context/AuthContext";
import CommentList from "./CommentList";

const CommentForm = ({ boardNo }) => {
  const { auth } = useContext(AuthContext);
  const [commentContent, setCommentContent] = useState("");
  const [success, onSuccess] = useState(false);

  const handleInsertComment = (e) => {
    e.preventDefault();

    if (commentContent.trim() === "") {
      alert("내용을 작성해주세요");
      return;
    }

    if (!auth.isAuthenticated) {
      alert("로그인 부터하셈ㅋ");
      return;
    }

    axios
      .post(
        "http://localhost:8081/comments",
        {
          refBoardNo: boardNo,
          commentContent: commentContent,
        },
        {
          headers: {
            Authorization: `Bearer ${auth.accessToken}`,
          },
        }
      )
      .then((response) => {
        if (response.status === 201) {
          alert("성공");
          setCommentContent("");
          onSuccess((success) => !success);
        }
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <Container>
        <Form onSubmit={handleInsertComment}>
          <Title>댓글작성</Title>
          <Input
            type="text"
            value={commentContent}
            placeholder="댓글을 작성해보아요~"
            onChange={(e) => setCommentContent(e.target.value)}
          />
          <Button>작성하기</Button>
        </Form>
        <CommentList boardNo={boardNo} success={success} />
      </Container>
    </>
  );
};

export default CommentForm;

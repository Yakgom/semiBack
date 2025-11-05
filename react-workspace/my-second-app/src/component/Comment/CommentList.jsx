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
  CommentContainer,
  CommentItem,
  CommentAuthor,
  CommentContent,
  CommentDate,
} from "../styles/Styles";
import { AuthContext } from "../context/AuthContext";

const CommentList = ({ boardNo, success }) => {
  const [comments, setComments] = useState([]);
  useEffect(() => {
    axios
      .get(`http://localhost:8081/comments?boardNo=${boardNo}`)
      .then((result) => {
        setComments(result.data);
      })
      .catch((err) => {
        console.error("댓글 조회 실패:", err);
      });
  }, [success]);
  return (
    <>
      <CommentContainer>
        {comments.length === 0 ? (
          <CommentItem>
            <CommentAuthor>댓글이</CommentAuthor>
            <CommentContent>하나도</CommentContent>
            <CommentDate>없어용</CommentDate>
          </CommentItem>
        ) : (
          comments.map((comment) => {
            return (
              <CommentItem>
                <CommentAuthor>{comment.commentWriter}</CommentAuthor>
                <CommentContent>{comment.commentContent}</CommentContent>
                <CommentDate>{comment.createDate}</CommentDate>
              </CommentItem>
            );
          })
        )}
      </CommentContainer>
    </>
  );
};

export default CommentList;

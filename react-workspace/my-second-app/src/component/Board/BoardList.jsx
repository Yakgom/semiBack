import {
  Board,
  BoardOuter,
  BoardTitle,
  BoardWriter,
  Button,
  Container,
  CreateDate,
  Title,
} from "../styles/Styles";
import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const BoardList = () => {
  const navi = useNavigate();
  const [page, setPage] = useState(0);
  const [boards, setBoards] = useState([]);
  const [hasMore, setHasMore] = useState(true);

  const increasePage = () => {
    setPage((page) => page + 1);
  };

  useEffect(() => {
    axios
      .get(`http://localhost:8081/boards?page=${page}`)
      .then((response) => {
        console.log(response);
        setBoards([...boards, ...response.data]);
        if (response.data.length < 3) {
          setHasMore(false);
        }
      })
      .catch((err) => {
        console.log(err);
      });
  }, [page]);

  return (
    <Container>
      <Title>게시판이야용</Title>
      <Button style={{ margin: "0" }} onClick={() => navi("/form")}>
        글쓰기
      </Button>
      <BoardOuter>
        <Board style={{ background: "lightpink" }}>
          <BoardWriter>글 번호</BoardWriter>
          <BoardTitle>글 제목</BoardTitle>
          <BoardWriter>작성자</BoardWriter>
          <CreateDate>작성일</CreateDate>
        </Board>
        {boards.map((board) => (
          <Board
            key={board.boardNo}
            onClick={() => navi(`/boards/${board.boardNo}`)}
          >
            <BoardWriter>{board.boardNo}</BoardWriter>
            <BoardTitle>{board.boardTitle}</BoardTitle>
            <BoardWriter>{board.boardWriter}</BoardWriter>
            <CreateDate>{board.createDate}</CreateDate>
          </Board>
        ))}
      </BoardOuter>
      {hasMore && (
        <Button style={{ backgroundColor: "darkblue" }} onClick={increasePage}>
          더보기 버튼이다 ㅋㅋ{" "}
        </Button>
      )}
    </Container>
  );
};

export default BoardList;

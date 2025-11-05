import { useState, useContext, useEffect } from "react";
import { AuthContext } from "../context/AuthContext";
import { useNavigate } from "react-router-dom";
import {
  Button,
  Container,
  Form,
  ImagePreview,
  Input,
  Label,
  Title,
} from "../styles/Styles";
import axios from "axios";
const BoardForm = () => {
  const [boardTitle, setBoardTitle] = useState("");
  const [boardContent, setboardContent] = useState("");
  const [file, setFile] = useState(null);
  const { auth } = useContext(AuthContext);
  const navi = useNavigate();
  useEffect(() => {
    if (!auth.isAuthenticated) {
      alert("로그인을 먼저 진행해주시기 바랍니다");
      navi("/login");
    }
  }, [auth.isAuthenticated]);
  const handelFileChange = (e) => {
    const selectedFile = e.target.files[0];
    //console.log(selectedFile);
    const allowTypes = ["image/jpg", "image/jpeg", "image/png", "image/gif"];
    const maxSize = 1024 * 1024 * 10;
    if (selectedFile && !allowTypes.includes(selectedFile.type)) {
      alert("이미지만 올려주세요 확장자는 jpg등등 이런거만 가능합니다.");
      return;
    }
    if (selectedFile && selectedFile.size > maxSize) {
      alert("너무 용량이 커요 힘듭니다 서버가");
      return;
    }

    setFile(selectedFile);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!boardContent.trim() || !boardTitle.trim()) {
      alert("제목 및 내용은 꼭꼭 입력을 부탁드려요!");
      return;
    }

    const formData = new FormData();
    formData.append("boardTitle", boardTitle);
    formData.append("boardContent", boardContent);
    if (file) {
      formData.append("file", file);
    }

    axios
      .post("http://localhost:8081/boards", formData, {
        headers: {
          Authorization: `Bearer ${auth.accessToken}`,
          "Content-Type": "multipart/form-data",
        },
      })
      .then((result) => {
        console.log(result);
        if (result.status === 201) {
          alert("성공성공");
          navi("/boards");
        }
      })
      .catch((error) => {
        console.log(error);
      });
  };
  return (
    <Container>
      <Form onSubmit={handleSubmit}>
        <Title>게시글을 써보자</Title>

        <Label>제목</Label>
        <Input
          type="text"
          placeholder="제목쓰셈ㅋ"
          onChange={(e) => setBoardTitle(e.target.value)}
        />
        <Label>내용</Label>
        <Input
          type="text"
          placeholder="내용쓰셈ㅋ"
          onChange={(e) => setboardContent(e.target.value)}
        />
        <Label>작성자</Label>
        <Input
          type="text"
          value={auth.memberName}
          readOnly
          style={{ backgroundColor: "lightgray", fontWeight: "bold" }}
        />
        <Label>파일첨부</Label>
        <Input type="file" accept="image/*" onChange={handelFileChange} />
        <ImagePreview src="" alt="미리보기"></ImagePreview>
        <Button>작성하기</Button>
      </Form>
    </Container>
  );
};

export default BoardForm;

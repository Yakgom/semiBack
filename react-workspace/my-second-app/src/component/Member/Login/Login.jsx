import { Container, Form, Input, Title, Button } from "../../styles/Styles";
import { useContext, useState } from "react";
import axios from "axios";
import { AuthContext } from "../../context/AuthContext";

const Login = () => {
  const [memberId, setMemberId] = useState("");
  const [memberPwd, setMemberPwd] = useState("");
  const [msg, setMsg] = useState("");
  const [loading, isLoading] = useState(false);
  const { login } = useContext(AuthContext);

  const handleLogin = (e) => {
    e.preventDefault();
    const regexp = /^[a-zA-Z0-9]{3,20}$/;

    if (!regexp.test(memberId)) {
      setMsg("비밀번호는 영어 숫자만쓰셈 3자에서 20자 사이셈ㅋ");
      return;
    } else if (!regexp.test(memberPwd)) {
      setMsg("비밀번호는 영어 숫자만쓰셈 3자에서 20자 사이셈ㅋ");
      return;
    } else {
      setMsg("");
    }

    axios
      .post("http://localhost:8081/auth/login", {
        memberId,
        memberPwd,
      })
      .then((result) => {
        console.log(result);
        const { memberId, memberName, accessToken, refreshToken, role } =
          result.data;

        login(memberId, memberName, accessToken, refreshToken, role);
        alert("추카포카 🧨");
        window.location.href = "/";

        //console.log(memberId, memberName, accessToken, refreshToken, role);
        /*
        localStorage.setItem("memberId", memberId);
        localStorage.setItem("memberName", memberName);
        localStorage.setItem("accessToken", accessToken);
        localStorage.setItem("refreshToken", refreshToken);
        localStorage.setItem("role", role);
        // sessionSto도 가능
        */
      })
      .catch((error) => {
        //console.log(error);
        alert(error.response.data["error-message"]);
      });
  };

  return (
    <>
      <Container height="300px">
        <Form onSubmit={handleLogin}>
          <Title>로그인 싹싺김치</Title>
          <Input
            type="text"
            placeholder="아이디를 입력해주세요"
            onChange={(e) => setMemberId(e.target.value)}
          />
          <label style={{ fontSize: "13px", color: "red", padding: "4px" }}>
            {msg}
          </label>
          <Input
            type="password"
            placeholder="비밀번호를 입력해주세요"
            onChange={(e) => setMemberPwd(e.target.value)}
          ></Input>
          <Button type="submit">로그인 하셈 메롱메롱</Button>
        </Form>
      </Container>
    </>
  );
};

export default Login;

import { useNavigate } from "react-router-dom";
import { AuthContext } from "../../context/AuthContext";
import { useContext, useEffect, useState } from "react";
import {
  Button,
  Container,
  Form,
  Input,
  Tab,
  Tabs,
  Title,
} from "../../styles/Styles";
import ChangePassword from "./ChangePassword";
import DeleteMember from "./DeleteMember";

const Info = () => {
  const { auth } = useContext(AuthContext);
  const navi = useNavigate();
  const [active, setActive] = useState(true);
  const handleToggle = () => {
    setActive((active) => !active);
  };
  useEffect(() => {
    if (!auth.isAuthenticated) {
      alert("로그인을 먼저 진행해주시기 바랍니다");
      navi("/login");
    }
  }, []);

  return (
    <>
      <Container>
        <Form>
          <Title>{active ? "비밀번호 변경" : "회원탈퇴"}</Title>

          <Tabs>
            <Tab onClick={handleToggle}>다른메뉴보기 </Tab>
          </Tabs>

          <Input type="text" value={auth.memberId} readOnly />

          <Input type="text" value={auth.memberName} readOnly />

          {active ? <ChangePassword /> : <DeleteMember />}

          <Button onClick={() => navi(-1)}>뒤로가기</Button>
        </Form>
      </Container>
    </>
  );
};

export default Info;

import { Button, Input } from "../../styles/Styles";
import axios from "axios";
import { useState, useContext } from "react";
import { AuthContext } from "../../context/AuthContext";
import { useNavigate } from "react-router-dom";
const DeleteMember = () => {
  const [memberPwd, setPassword] = useState("");
  const { auth, logout } = useContext(AuthContext);
  const navi = useNavigate();
  const handelDelete = () => {
    axios
      .delete("http://localhost:8081/members", {
        headers: {
          Authorization: `Bearer ${auth.accessToken}`,
        },
        data: {
          memberPwd,
        },
      })
      .then((result) => {
        console.log(result);
        logout();
        navi("/");
      })
      .catch((err) => {
        console.log(err);
      });
  };
  return (
    <>
      <Input
        type="text"
        placeholder="비밀번호를 입력해주세요."
        required
        onChange={(e) => setPassword(e.target.value)}
      />

      <br />

      <Button onClick={handelDelete} type="button">
        탈퇴하기
      </Button>
    </>
  );
};

export default DeleteMember;

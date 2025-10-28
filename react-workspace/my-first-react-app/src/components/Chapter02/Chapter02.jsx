// AJAX 요청을 보내서 응답을 받아올 것
// 요번 타임 주제 => 회원들의 정보를 받아왔다고 가정
import styled from "styled-components";

const StyledDiv = styled.div`
  width: 100%;
  height: 200px;
  border: 1px solid lightgray;
  margin: 40px;
  background-color: ${(props) => (props.color ? props.color : "white")};
`;

const members = [
  {
    memberId: "admin",
    memberName: "짱구",
    email: "jjang9@kh.com",
    color: "green",
  },
  {
    memberId: "user01",
    memberName: "철수",
    email: "ironwater@kh.com",
    color: "lightgreen",
  },
  {
    memberId: "user02",
    memberName: "유리",
    email: "glass@kh.com",
    color: "lightblue",
  },
];

const MemberInfo = (props) => {
  // 구조분해
  console.log(props);
  const { memberId, memberName, email, color } = props.member;
  return (
    <StyledDiv color={color}>
      <h5>아이디 : {memberId}</h5>
      <strong>이름 : {memberName}</strong>
      <p>이메일 : {email}</p>
    </StyledDiv>
  );
};

const Chapter02 = () => {
  return (
    <>
      {members ? (
        members.map((e) => {
          return <MemberInfo member={e} key={e.memberId} />;
        })
      ) : (
        <h1>조회결과가없습니다</h1>
      )}

      {/* 2절
      <MemberInfo {...members[0]} />
      <MemberInfo {...members[1]} />
      <MemberInfo {...members[2]} />  */}

      {/*    
      1절
      <StyledDiv>
        <h5>아이디 : {members[0].memberId}</h5>
        <strong>이름 : {members[0].memberName}</strong>
        <p>이메일 : {members[0].email}</p>
      </StyledDiv>
      <StyledDiv>
        <h5>아이디 : {members[1].memberId}</h5>
        <strong>이름 : {members[1].memberName}</strong>
        <p>이메일 : {members[1].email}</p>
      </StyledDiv>
      <StyledDiv>
        <h5>아이디 : {members[2].memberId}</h5>
        <strong>이름 : {members[2].memberName}</strong>
        <p>이메일 : {members[2].email}</p>
      </StyledDiv> */}

      <pre>
        props사용시 주의할 점!
        <br />
        React의 함수형 컴포넌트는 항상 Pure하게 만들어야함!! React의 사용목적 :
        웹 애플리케이션의 UI(UserInterface) ☞ MVC(V) <br />
        필요한 값 입력받기 <br />
        요청보내기 <br />
        요청 결과 출력 <br />
        만들용도로 사용 <br />
        <br />
      </pre>
    </>
  );
};

export default Chapter02;

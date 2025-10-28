import Button from "./Button";
import FirstComponent from "./FirstComponent";
import { WhatIsJSX, WhatIsReact } from "./WhatisJSX";

const Fusion = () => {
  /*
        실습 : 함수형 컴포넌트 10개 만들어서 요리조리 조립해서 화면에
        렌더링 해보기 시작(제한시간 10분)
    */
  return (
    <>
      <FirstComponent />
      <WhatIsReact />

      <hr />

      <WhatIsJSX />
      <Button />
    </>
  );
};

export default Fusion;

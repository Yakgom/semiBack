import "./Header.css";
import { useNavigate } from "react-router-dom";
const Header = () => {
  const navi = useNavigate();

  return (
    <>
      <div className="header-div">
        <ul className="header-ul">
          <li>
            <a href="/02">02</a>
          </li>
          <li>
            <a href="/01">Chapter01</a>
          </li>
          <li>
            <a
              onClick={() => {
                navi("/fusion");
              }}
            >
              유즈네비 퓨전
            </a>
          </li>
          <li>
            <a
              onClick={() => {
                navi("/01");
              }}
            >
              유즈네비 01
            </a>
          </li>
          <li>
            <a
              onClick={() => {
                navi("/03");
              }}
            >
              03
            </a>
          </li>

          <li>
            <a
              onClick={() => {
                navi("/input");
              }}
            >
              input
            </a>
          </li>

          <li>
            <a
              onClick={() => {
                navi("/foods");
              }}
            >
              Foods
            </a>
          </li>
        </ul>
      </div>
    </>
  );
};

export default Header;

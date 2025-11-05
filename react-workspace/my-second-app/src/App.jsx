import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import Footer from "./component/common/Footer/Footer";
import Header from "./component/common/Header/Header";
import Nav from "./component/common/Nav/Nav";
import { Routes, Route } from "react-router-dom";
import Home from "./component/common/Home/Home";
import Join from "./component/Member/Join/Join";
import Login from "./component/Member/login/Login";
import { AuthProvider } from "./component/context/AuthContext";
import Info from "./component/Member/Info/Info";
import BoardList from "./component/Board/BoardList";
import Form from "./component/Board/BoardForm";
import BoardDetail from "./component/Board/BoardDetail";

function App() {
  return (
    <>
      <AuthProvider>
        <Header />

        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/join" element={<Join />} />
          <Route path="/login" element={<Login />} />
          <Route path="/info" element={<Info />} />
          <Route path="/boards" element={<BoardList />} />
          <Route path="/form" element={<Form />} />
          <Route path="/boards/:id" element={<BoardDetail />} />
          <Route
            path="/*"
            element={<div>돌어라어ㅑ랃어ㅐㄹ걷ㄴ재거ㅐㄷㅈ너</div>}
          />
        </Routes>

        <Footer />
      </AuthProvider>
    </>
  );
}

export default App;

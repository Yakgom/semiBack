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

function App() {
  return (
    <>
      <Header />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/join" element={<Join />} />
      </Routes>

      <Footer />
    </>
  );
}

export default App;

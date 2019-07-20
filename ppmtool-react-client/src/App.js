import React from "react";
import Dashboard from "./components/Dashboard.js";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css"; 
import "./App.css";


function App() {
  return (
    <div className="App">
      <Header />
      <Dashboard />
    </div>
  );
}

export default App;

import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Dashboard from "./components/Dashboard.js";
import Header from "./components/Layout/Header";
import "./App.css";
import AddProject from "./components/Project/AddProject.js";

function App() {
  return (
    <Router>
      <div className="App">
        <Header />
        <Route exact path="/dashboard" component={Dashboard}/>
        <Route exact path="/addProject" component={AddProject}/>
      </div>
    </Router>
  );
}

export default App;

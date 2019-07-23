import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Provider } from "react-redux";
import store from "./store";
import Dashboard from "./components/Dashboard.js";
import Header from "./components/Layout/Header";
import "./App.css";
import AddProject from "./components/Project/AddProject.js";
import UpdateProject from "./components/Project/UpdateProject";

function App() {
  return (
    <Provider store={store}>
      <Router>
        <div className="App">
          <Header />
          <Route exact path="/dashboard" component={Dashboard} />
          <Route exact path="/addProject" component={AddProject} />
          <Route exact path="/updateProject/:id" component={UpdateProject} />
        </div>
      </Router>
    </Provider>
  );
}

export default App;

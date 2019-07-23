import axios from "axios";
import {
  GET_ERRORS,
  GET_PROJECTS,
  GET_PROJECT,
  DELETE_PROJECT
} from "../actions/types";

export const createProject = (project, history) => async dispatch => {
  try {
    await axios.post("/api/project", project);
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const getProjects = () => async dispatch => {
  const res = await axios.get("/api/project/all");

  dispatch({
    type: GET_PROJECTS,
    payload: res.data
  });
};

export const getProject = (id, history) => async dispatch => {
  try {
    const res = await axios.get(`/api/project/${id}`);

    dispatch({
      type: GET_PROJECT,
      payload: res.data
    });
  } catch (error) {
    history.push("/dashboard");
  }
};

export const updateProject = (
  projectId,
  project,
  history
) => async dispatch => {
  try {
    await axios.put(`/api/project/${projectId}`, project);
    history.push("/dashboard");
    dispatch({
      type: GET_ERRORS,
      payload: {}
    });
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error.response.data
    });
  }
};

export const deleteProject = (id, history) => async dispatch => {
  try {
    if (
      window.confirm(
        "Are you sure? This will delete project along with all tasks associated with it."
      )
    ) {
      await axios.delete(`/api/project/${id}`);

      dispatch({
        type: DELETE_PROJECT,
        payload: id
      });
    }
  } catch (error) {
    history.push("/dashboard");
  }
};

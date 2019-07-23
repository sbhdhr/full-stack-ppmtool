import React, { Component } from "react";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";
import { connect } from "react-redux";
import { deleteProject } from "../../actions/projectActions";

class ProjectItem extends Component {
  onDeleteClick = id => {
    this.props.deleteProject(id);
  };

  render() {
    const { project } = this.props;
    return (
      //<!-- Project Item Component -->
      <div className="container">
        <div className="card card-body bg-light mb-3">
          <div className="row">
            <div className="col-4">
              <span className="mx-auto">{project.projectIdentifier}</span>
            </div>
            <div className="col-8">
              <h3>{project.projectName}</h3>
              <p>{project.description}</p>
            </div>
          </div>
          <div className="row">
            <div className="col-4">
              <a href="#">
                <li className="list-group-item board text-center">
                  <i className="far fa-clipboard" />
                  <span className="pl-2">Project Board</span>
                </li>
              </a>
            </div>
            <div className="col-4">
              <Link to={`/updateProject/${project.projectIdentifier}`}>
                <li className="list-group-item update text-center">
                  <i className="far fa-edit" />
                  <span className="pl-2">Update Project Info</span>
                </li>
              </Link>
            </div>
            <div className="col-4">
              <a href="#">
                <li
                  className="list-group-item delete text-center"
                  onClick={this.onDeleteClick.bind(
                    this,
                    project.projectIdentifier
                  )}
                >
                  <i className="fa fa-minus-circle" />
                  <span className="pl-2">Delete Project</span>
                </li>
              </a>
            </div>
          </div>
        </div>
      </div>
      //<!-- End of Project Item Component -->
    );
  }
}

ProjectItem.propTypes = {
  deleteProject: PropTypes.func.isRequired
};



export default connect(
  null,
  { deleteProject }
)(ProjectItem);

import React, { Component } from "react";

class ProjectItem extends Component {
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
                <a href="#">
                  <li className="list-group-item update text-center">
                    <i className="far fa-edit" />
                    <span className="pl-2">Update Project Info</span>
                  </li>
                </a>
                </div>
                <div className="col-4">
                <a href="#">
                  <li className="list-group-item delete text-center">
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

export default ProjectItem;

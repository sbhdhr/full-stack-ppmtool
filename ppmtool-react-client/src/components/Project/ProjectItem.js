import React, { Component } from "react";

class ProjectItem extends Component {
  render() {
    return (
        //<!-- Project Item Component -->
        <div className="container">
            <div className="card card-body bg-light mb-3">
                <div className="row">
                    <div className="col-2">
                        <span className="mx-auto">REACT</span>
                    </div>
                    <div className="col-lg-6 col-md-4 col-8">
                        <h3>Spring / React Project</h3>
                        <p>Project to create a Kanban Board with Spring Boot and React</p>
                    </div>
                    <div className="col-md-4 d-none d-lg-block">
                        <ul className="list-group">
                            <a href="#">
                                <li className="list-group-item board text-center">
                                    <i className="far fa-clipboard"></i><span className="pl-2">Project Board</span>
                                </li>
                            </a>
                            <a href="#">
                                <li className="list-group-item update text-center">
                                    <i className="far fa-edit"></i><span className="pl-2">Update Project Info</span>
                                </li>
                            </a>
                            <a href="#">
                                <li className="list-group-item delete text-center">
                                    <i className="fa fa-minus-circle"></i><span className="pl-2">Delete Project</span>
                                </li>
                            </a>
                           
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        //<!-- End of Project Item Component -->
    );
  }
}

export default ProjectItem;

import React, { Component } from "react";

class ProjectItem extends Component {
  render() {
    return (
        //<!-- Project Item Component -->
        <div class="container">
            <div class="card card-body bg-light mb-3">
                <div class="row">
                    <div class="col-2">
                        <span class="mx-auto">REACT</span>
                    </div>
                    <div class="col-lg-6 col-md-4 col-8">
                        <h3>Spring / React Project</h3>
                        <p>Project to create a Kanban Board with Spring Boot and React</p>
                    </div>
                    <div class="col-md-4 d-none d-lg-block">
                        <ul class="list-group">
                            <a href="#">
                                <li class="list-group-item board text-center">
                                    <i class="far fa-clipboard"></i><span class="pl-2">Project Board</span>
                                </li>
                            </a>
                            <a href="#">
                                <li class="list-group-item update text-center">
                                    <i class="far fa-edit"></i><span class="pl-2">Update Project Info</span>
                                </li>
                            </a>
                            <a href="#">
                                <li class="list-group-item delete text-center">
                                    <i class="fa fa-minus-circle"></i><span class="pl-2">Delete Project</span>
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

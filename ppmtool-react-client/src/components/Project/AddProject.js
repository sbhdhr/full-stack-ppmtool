import React, { Component } from "react";

class AddProject extends Component {
  render() {
    return (
      //<!-- Start of Project FORM -->

      <div className="project">
        <div className="container">
          <div className="row">
            <div className="col-md-8 m-auto">
              <h5 className="display-4 text-center">Create Project form</h5>
              <hr />
              <form>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg "
                    placeholder="Project Name"
                  />
                </div>
                <div className="form-group">
                  <input
                    type="text"
                    className="form-control form-control-lg"
                    placeholder="Unique Project ID"
                  />
                </div>
                {
                  //<!-- disabled for Edit Only!! remove "disabled" for the Create operation -->
                }
                <div className="form-group">
                  <textarea
                    className="form-control form-control-lg"
                    placeholder="Project Description"
                  />
                </div>
                <h6>Start Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="start_date"
                  />
                </div>
                <h6>Estimated End Date</h6>
                <div className="form-group">
                  <input
                    type="date"
                    className="form-control form-control-lg"
                    name="end_date"
                  />
                </div>

                <input type="submit" className="btn btn-primary btn-block mt-4" />
              </form>
            </div>
          </div>
        </div>
      </div>

      //<!-- END OF PROJECT FORM -->
    );
  }
}

export default AddProject;

import React, { Component } from "react";
import StudentService from "../services/StudentService";
import withNavigateHook from "./withNavigateHook";

class StudentCreateComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      stdName: "",
      stdGen: "",
      stdCourse: "",
      stdAddr: "",
      message: "",
    };
  }

  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });
  }

  saveStudent = (event) => {
    event.preventDefault();
    let student = {
      stdName: this.state.stdName,
      stdGen: this.state.stdGen,
      stdCourse: this.state.stdCourse,
      stdAddr: this.state.stdAddr,
    };
    StudentService.createStudent(student).then((response) => {
      this.setState({ message: response.data });
    });
    setTimeout(() => {
      this.props.navigation("/all");
    }, 2000);
  };
  render() {
    return (
      <div>
        <h3 className="text-center">STUDENTS REGISTER PAGE</h3>
        <form>
          NAME :
          <input
            type="text"
            name="stdName"
            id="stdName"
            value={this.state.stdName}
            className="form-control"
            onChange={(event) => this.handleChange(event)}
          />
          GENDER :
          <input
            type="radio"
            name="stdGen"
            id="stdGen"
            value="Male"
            onChange={(event) => this.handleChange(event)}
          />
          Male
          <input
            type="radio"
            name="stdGen"
            id="stdGen"
            value="Female"
            onChange={(event) => this.handleChange(event)}
          />
          Female
          <br />
          COURSE :
          <select
            name="stdCourse"
            id="stdCourse"
            onChange={(event) => this.handleChange(event)}
            className="form-control"
          >
            <option value="">SELECT</option>
            <option value="JAVA">JAVA</option>
            <option value="DOT NET">DOT NET</option>
            <option value="SALESFORCE">SALESFORCE</option>
            <option value="DEVOPS">DEVOPS</option>
          </select>
          ADDRESS :
          <textarea
            name="stdAddr"
            id="stdAddr"
            onChange={(event) => this.handleChange(event)}
            className="form-control"
          ></textarea>
          <br />
          <button
            className="btn btn-success"
            onClick={(event) => this.saveStudent(event)}
          >
            CREATE
          </button>
        </form>
        {this.state.message && (
          <div className="text-center">
            <strong>{this.state.message}</strong>
          </div>
        )}
      </div>
    );
  }
}

export default withNavigateHook(StudentCreateComponent);

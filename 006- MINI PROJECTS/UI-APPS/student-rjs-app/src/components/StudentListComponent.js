import React, { Component } from "react";
import StudentService from "../services/StudentService";
import withNavigateHook from "./withNavigateHook";

class StudentListComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      students: [],
      message: "",
    };
  }

  deleteStudent(id) {
    StudentService.deleteStudent(id).then((response) => {
      this.setState({
        students: this.state.students.filter((student) => student.stdId !== id),
        message: response.data,
      });
    });
  }

  editStudent(id) {
    this.props.navigation("/edit/" + id);
  }

  componentDidMount() {
    StudentService.getAllStudents().then((response) => {
      this.setState({ students: response.data });
    });
  }

  render() {
    return (
      <>
        <h3 className="text-center">STUDENTS DATA PAGE</h3>
        <table className="table table-hover">
          <thead>
            <tr className="bg-info text-white">
              <th>ID</th>
              <th>NAME</th>
              <th>GENDER</th>
              <th>COURSE</th>
              <th>ADDRESS</th>
              <th>OPERATION</th>
            </tr>
          </thead>
          <tbody>
            {this.state.students.map((student) => (
              <tr key={student.stdId}>
                <td>{student.stdId}</td>
                <td>{student.stdName}</td>
                <td>{student.stdGen}</td>
                <td>{student.stdCourse}</td>
                <td>{student.stdAddr}</td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => this.deleteStudent(student.stdId)}
                  >
                    DELETE
                  </button>
                  &nbsp;
                  <button
                    className="btn btn-warning"
                    onClick={() => this.editStudent(student.stdId)}
                  >
                    EDIT
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
        {this.state.message && (
          <div className="text-center">
            <strong>{this.state.message}</strong>
          </div>
        )}
      </>
    );
  }
}

export default withNavigateHook(StudentListComponent);

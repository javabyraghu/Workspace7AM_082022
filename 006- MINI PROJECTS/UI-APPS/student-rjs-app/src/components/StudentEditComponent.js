import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import StudentService from "../services/StudentService";

const StudentEditComponent = () => {
  const initialFormState = {
    stdId: "",
    stdName: "",
    stdGen: "",
    stdCourse: "",
    stdAddr: "",
    message: "",
  };

  const [student, setStudent] = useState(initialFormState);
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    StudentService.getOneStudent(id).then((response) =>
      setStudent(response.data)
    );
  }, [id, setStudent]);

  const handleChange = (event) => {
    const { name, value } = event.target;
    setStudent({ ...student, [name]: value });
  };

  const updateStudent = (event) => {
    event.preventDefault();
    StudentService.updateStudent(student).then((response) => {
      setStudent({
        ...student,
        message: response.data,
      });
      setTimeout(() => {
        navigate("/all");
      }, 2000);
    });
  };

  return (
    <div>
      <h3 className="text-center">STUDENTS UPDATE PAGE</h3>
      <form>
        ID :
        <input
          type="text"
          name="stdId"
          id="stdId"
          value={student.stdId}
          className="form-control"
          readOnly
        />
        NAME :
        <input
          type="text"
          name="stdName"
          id="stdName"
          value={student.stdName}
          className="form-control"
          onChange={handleChange}
        />
        GENDER :
        <input
          type="radio"
          name="stdGen"
          id="stdGen"
          value={student.stdGen}
          checked={student.stdGen === "Male"}
          onChange={handleChange}
        />
        Male
        <input
          type="radio"
          name="stdGen"
          id="stdGen"
          value={student.stdGen}
          checked={student.stdGen === "Female"}
          onChange={handleChange}
        />
        Female
        <br />
        COURSE :
        <select
          name="stdCourse"
          id="stdCourse"
          onChange={handleChange}
          className="form-control"
          value={student.stdCourse}
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
          value={student.stdAddr}
          onChange={handleChange}
          className="form-control"
        ></textarea>
        <br />
        <button className="btn btn-success" onClick={updateStudent}>
          UPDATE
        </button>
      </form>
      {student.message && (
        <div className="text-center">
          <strong>{student.message}</strong>
        </div>
      )}
    </div>
  );
};

export default StudentEditComponent;

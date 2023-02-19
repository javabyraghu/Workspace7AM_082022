import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import StudentListComponent from "./StudentListComponent";
import StudentCreateComponent from "./StudentCreateComponent";
import StudentEditComponent from "./StudentEditComponent";
import NotFoundComponent from "./NotFoundComponent";
function NavBarComponent() {
  return (
    <Router>
      <nav className="navbar navbar-expand-lg navbar-light bg-primary">
        <a className="navbar-brand text-white" href="#">
          R-APP
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mr-auto">
            <li className="nav-item ">
              <Link to="/all" className="nav-link text-white">
                VIEW ALL
              </Link>
            </li>
            <li className="nav-item">
              <Link to="/add" className="nav-link text-white">
                REGISRTER
              </Link>
            </li>
            <li className="nav-item dropdown">
              <a
                className="nav-link dropdown-toggle text-white"
                href="#"
                role="button"
                data-toggle="dropdown"
                aria-expanded="false"
              >
                OPERATIONS
              </a>
              <div className="dropdown-menu">
                <Link to="/all" className="nav-link">
                  VIEW ALL
                </Link>
                <Link to="/add" className="nav-link">
                  REGISRTER
                </Link>
              </div>
            </li>
          </ul>
        </div>
      </nav>
      <Routes>
        <Route path="/all" element={<StudentListComponent />}></Route>
        <Route path="/add" element={<StudentCreateComponent />}></Route>
        <Route path="/edit/:id" element={<StudentEditComponent />}></Route>
        <Route path="/" element={<StudentListComponent />}></Route>
        <Route path="*" element={<NotFoundComponent />}></Route>
      </Routes>
    </Router>
  );
}

export default NavBarComponent;

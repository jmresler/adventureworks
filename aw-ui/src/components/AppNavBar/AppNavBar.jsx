import React, { Component } from "react";
import {Navbar, Nav, Form, FormControl} from "react-bootstrap";
import {Link} from "react-router-dom";
import Dropdown from "react-bootstrap/Dropdown"
import DropdownButton from "react-bootstrap/DropdownButton";
import Button from "react-bootstrap/Button";
import axios from "axios";
import {Constants} from '../../assets/js/Constants/Constants'

/**
 * 
 */
class AppNavBar extends Component {
  
  _isMounted = false;

  /**
   * 
   * @param {*} props 
   */
  constructor(props) {
    super(props);
    this.state = {
      hasError: false,
      count: 0,
      menu: []
    }

    this.loadMenus = this.loadMenus.bind(this);
    this.onSearchSubmit = this.onSearchSubmit.bind(this);
    this.searchKeyPress = this.searchKeyPress.bind(this);
    this.onSearchBtnPress = this.onSearchBtnPress.bind(this);
    this.onSignonBtnPress = this.onSignonBtnPress.bind(this);
  }

  /**
   * 
   */
  componentDidMount = () => {
    this._isMounted = true;
    this.loadMenus();
  }

  /**
   * 
   */
  static getDerivedStateFromError = (error) => {
    return { hasError: true };
  }

  /**
   * 
   */
  componentDidCatch = (error, info) => {
    // You can also log the error to an error reporting service
  }

  /**
   * 
   */
  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    return null;
  }

  /**
   * 
   */
  componentDidUpdate = () => {

  }

  /**
   * 
   */
  componentWillUnmount = () => {
    this._isMounted = false;
  } 

  /**
   * 
   */
  loadMenus = () => {
    axios.get(Constants.MENUS_URL)
          .then(response => {
            if (this._isMounted) {
              this.setState({menu:response.data});
            }
        }).catch(error => {
          console.log("error caught loading menus -> " + error)
        }).finally(() => console.log("In finally block"));
  }
  
  /**
   * 
   * @param {*} searchTerms 
   */
  onSearchSubmit(searchTerms) {
    if (!/^.*;+.*$/.test(searchTerms)) {
      console.log("did not match")
    } else {
      console.log("matched")
    }
  }

  /*
   * @JMR
   * This method has a problem that seems to cause a complete page refresh...
   * Defeats the purpose of an SPA so it MUST BE FIXED!!!
   */
  searchKeyPress = (event) => {
    // submit key pressed
    if (event.which === 13) {
      this.onSearchSubmit(document.getElementById("search-fld").value);
    }
    console.log(event.which);
  }

  /**
   * 
   */
  onSearchBtnPress = (event) => {
    this.onSearchSubmit(document.getElementById("search-fld").value);
  }

  /**
   * 
   */
  onSignonBtnPress = (event) => {

  }

  /**
   * 
   */
  render = () => {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    let paddedBtn = {margin:7};
    

    return (
      <Navbar bg="primary" variant="dark" sticky="top">
        <Navbar.Brand href="#home">Adventure Works 2017</Navbar.Brand>
        <Nav className="mr-auto">
          <Button variant="outline-light" id="home-btn" className="border border-0 border-dark" style={paddedBtn}>Home</Button>
          <Button variant="outline-light" id="features-btn" className="border border-0 border-dark" style={paddedBtn}>Features</Button>
          <DropdownButton id="dropdown-basic-button" variant="outline-light" className="border border-0 border-primary" title="Employees" style={paddedBtn}>
            <Dropdown.Item href="#/">Menu Dropdown Item 1</Dropdown.Item>
            <Dropdown.Divider/>
            <Dropdown.Item hre="#/">This is where the menu items go...</Dropdown.Item>
            <Dropdown.Divider/>
          </DropdownButton>
        </Nav>
        <Form inline>
          <FormControl type="text" id="search-fld" placeholder="Search" className="mr-sm-2"  onKeyPress={this.searchKeyPress}/>
          <Button variant="outline-light" id="search-btn" onClick={this.onSearchBtnPress} className="border border-0 border-dark">Search</Button>
          <Link to="/signon">
            <Button variant="outline-light" id="signon-btn" onClick={this.onSignonBtnPress} style={paddedBtn} className="border border-0 border-dark">Signon</Button>
          </Link>
        </Form>
      </Navbar>
    );
  }
}


export default AppNavBar;
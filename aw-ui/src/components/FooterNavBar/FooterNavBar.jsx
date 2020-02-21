import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, Nav } from "react-bootstrap";

class FooterNavBar extends Component { 

  constructor(props) {
    super(props);
    this.state = {
      hasError: false,
    }
  }

  componentDidMount = () => {
    console.log('FooterNavBar mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('FooterNavBar getSnapshotBeforeUpdate', prevProps, prevState);
    return null;
  }

  componentDidUpdate = () => {
    console.log('FooterNavBar did update');
  }

  componentWillUnmount = () => {
    console.log('FooterNavBar will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    let navStyle={marginRight:"auto", marginLeft:"auto", marginBottom:0};
    let whiteLinks = {color:"white", paddinLeft:10, paddingRight:10};

    return (
      <Navbar id="footer">
        <Nav className="mr-auto" style={navStyle}>
          <Link to="/" style={whiteLinks}><i className="fa fa-home" style={{paddingRight:5}}></i>Home</Link>
          <Link to="/about-us" style={whiteLinks}>About Us</Link>
          <Link to="/site-map" style={whiteLinks}>Site Map</Link>
          <Link to="/feedback" style={whiteLinks}>Feedback</Link>
          <Link to="/contact-us" style={whiteLinks}><i className="fa fa-envelope-o" style={{paddingRight:5}}></i>Contact Us</Link>          
        </Nav>
      </Navbar>
    );
  }
}

export default FooterNavBar;
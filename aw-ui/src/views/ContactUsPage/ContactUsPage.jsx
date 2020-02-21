import React, { Component } from 'react';
import AppNavBar from "../../components/AppNavBar/AppNavBar";
import FooterNavBar from "../../components/FooterNavBar/FooterNavBar";

class ContactUsPage extends Component { 

  constructor(props)  {
    super(props);
    
    this.state = {
      hasError: false,
    }
  
  }

  componentDidMount = () => {
    console.log('ContactUs mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getDerivedStateFromProps = (nextProps, prevState) => {
    console.log('ContactUs getDerivedStateFromProps', nextProps, prevState);
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('ContactUs getSnapshotBeforeUpdate', prevProps, prevState);
  }

  componentDidUpdate = () => {
    console.log('ContactUs did update');
  }

  componentWillUnmount = () => {
    console.log('ContactUs will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    return (
      <>
        <AppNavBar/>
        <FooterNavBar/>
     </>
    );
  }
}

export default ContactUsPage;
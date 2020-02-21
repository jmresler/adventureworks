import React, { Component } from 'react';
import AppNavBar from "../../components/AppNavBar/AppNavBar";
import FooterNavBar from "../../components/FooterNavBar/FooterNavBar";

class LandingPage extends Component { 
  state = {
    hasError: false,
  }

  componentDidMount = () => {
    console.log('LandingPage mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getDerivedStateFromProps = (nextProps, prevState) => {
    console.log('LandingPage getDerivedStateFromProps', nextProps, prevState);
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('LandingPage getSnapshotBeforeUpdate', prevProps, prevState);
  }

  componentDidUpdate = () => {
    console.log('LandingPage did update');
  }

  componentWillUnmount = () => {
    console.log('LandingPage will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    return (
       <React.Fragment>
         <AppNavBar/>
         <FooterNavBar/>
       </React.Fragment>
    );
  }
}

export default LandingPage;
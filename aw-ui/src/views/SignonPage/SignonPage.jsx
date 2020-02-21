import React, { Component } from 'react';
import FooterNavBar from '../../components/FooterNavBar/FooterNavBar';
import AppNavBar from '../../components/AppNavBar/AppNavBar';
import TabbedContainer from "../../components/TabbedContainers/TabbedContainer";

class SignonPage extends Component { 
  state = {
    hasError: false,
  }

  componentDidMount = () => {
    console.log('SignonPage mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('SignonPage getSnapshotBeforeUpdate', prevProps, prevState);
    return null;
  }

  componentDidUpdate = () => {
    console.log('SignonPage did update');
  }

  componentWillUnmount = () => {
    console.log('SignonPage will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    return (
       <React.Fragment>
         <AppNavBar/>
         <TabbedContainer/>
         <FooterNavBar/>
       </React.Fragment>
    );
  }
}

export default SignonPage;
import React, { Component } from 'react';
import AppNavBar from '../../components/AppNavBar/AppNavBar';
import FooterNavBar from '../../components/FooterNavBar/FooterNavBar';

class ErrorPage extends Component {
  
  constructor(props) {
    super(props);
    this.state = {
      hasError: false,
      errorMessage : props.errorMessage
    }
  }


  componentDidMount = () => {
    console.log('ErrorPage mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getDerivedStateFromProps = (nextProps, prevState) => {
    console.log('ErrorPage getDerivedStateFromProps', nextProps, prevState);
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('ErrorPage getSnapshotBeforeUpdate', prevProps, prevState);
  }

  componentDidUpdate = () => {
    console.log('ErrorPage did update');
  }

  componentWillUnmount = () => {
    console.log('ErrorPage will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }


    return (
       <React.Fragment>
         <AppNavBar />
         <FooterNavBar/>
       </React.Fragment>
    );
  }
}

export default ErrorPage;
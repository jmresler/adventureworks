import React, { Component } from 'react';
import AppNavBar from '../../components/AppNavBar/AppNavBar';
import FooterNavBar from '../../components/FooterNavBar/FooterNavBar';
import FeedbackForm from '../../components/forms/FeedbackForm';

class FeedbackPage extends Component { 

  constructor(props) {
    super(props);
    this.state = {
      hasError: false
    }

  }

  componentDidMount = () => {
    console.log('Feedback mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('Feedback getSnapshotBeforeUpdate', prevProps, prevState);
  }

  componentDidUpdate = () => {
    console.log('Feedback did update');
  }

  componentWillUnmount = () => {
    console.log('Feedback will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    let contactFormStyle = {borderRadius:7, marginTop:35, marginLeft:'auto', marginRight:'auto', backgroundColor:'#FFFFFF', padding:20, width:'33%'};

    return (
      <>
        <AppNavBar/>
          <div style={contactFormStyle}>
            <h4>Provide Your Feedback</h4>
            <FeedbackForm/>
          </div>
        <FooterNavBar/>
     </>
    );
  }
}

export default FeedbackPage;
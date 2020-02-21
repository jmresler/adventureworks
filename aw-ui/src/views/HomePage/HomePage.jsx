import React, { Component } from 'react';
import AppNavBar from '../../components/AppNavBar/AppNavBar';
import FooterNavBar from '../../components/FooterNavBar/FooterNavBar';

export default class HomePage extends Component {

  constructor(props) {
    super(props);

    this.state = {
      hasError: false,
    }
  }

  componentDidMount = () => {
    console.log('HomePage mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    return null;
  }

  componentDidUpdate = () => {
    console.log('HomePage did update');
  }

  componentWillUnmount = () => {
    console.log('HomePage will unmount');
  }

  render() {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }

    let cStyle = { marginLeft: "auto", marginRight: "auto", marginTop: 150, width: 1000, height: 950 };
    return (
      <React.Fragment>
        <AppNavBar />
        <div style={cStyle} >
          
        </div>
        <FooterNavBar />
      </React.Fragment>
    );
  }
}

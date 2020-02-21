import React, { Component } from 'react';
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

export default class AppCard extends Component { 

  constructor(props) {
    super(props);
    this.state = {
      hasError: false,
      cardLbl : props.cardLbl,      
      cardTxt: props.cardTxt,
      btnTxt: props.btnTxt,
      imgUrl: props.imgUrl
    }
  }

  componentDidMount = () => {
    console.log('Card mounted');
  }

  static getDerivedStateFromError(error) {
    // getDerivedStateFromError -> Update state so the next render will show the fallback UI.
    return { hasError: true };
  }

  componentDidCatch(error, info) {
    // You can also log the error to an error reporting service
  }

  getDerivedStateFromProps = (nextProps, prevState) => {
    console.log('Card getDerivedStateFromProps', nextProps, prevState);
  }

  getSnapshotBeforeUpdate = (prevProps, prevState) => {
    console.log('Card getSnapshotBeforeUpdate', prevProps, prevState);
  }

  componentDidUpdate = () => {
    console.log('Card did update');
  }

  componentWillUnmount = () => {
    console.log('Card will unmount');
  }

  render () {
    if (this.state.hasError) {
      return <h1>Something went wrong.</h1>;
    }
    
    return (
       <React.Fragment>
          <Card style={{ width: '12rem' }}>
            <Card.Img variant="top" style={{border:"1px solid lightgray", borderRadius: "50%"}} src={this.state.imgUrl} />
            <Card.Body>
              <Card.Title>{this.state.cardLbl}</Card.Title>
              <Card.Text style={{fontSize:12}}>
                {this.state.cardTxt}
              </Card.Text>
              <Button variant="primary" size="sm">{this.state.btnTxt}</Button>
            </Card.Body>
          </Card>       
        </React.Fragment>
    );
  }
}

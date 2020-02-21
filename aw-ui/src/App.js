import React, {Component} from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import HomePage from "./views/HomePage/HomePage";
import LandingPage from "./views/LandingPage/LandingPage";
import SignonPage from "./views/SignonPage/SignonPage";
import AboutUs from "./views/AboutUsPage/AboutUsPage";
import ContactUs from "./views/ContactUsPage/ContactUsPage";
import SiteMapPage from "./views/SiteMapPage/SiteMapPage";
import FeedbackPage from "./views/FeedbackPage/FeedbackPage";
import ErrorPage from './views/ErrorPage/ErrorPage';

import 'bootstrap/dist/css/bootstrap.min.css';

export default class App extends Component{

  constructor(props) {
    super(props);
    this.state = {
      data: [],
      isLoading: true,
      error: null
    };
  }

  componentDidMount() {
    this.setState({ isLoading: false });
  }


  render() {
    const { isLoading, error } = this.state;

    if (error) {
      return <p>{error.message}</p>;
    }
    
    if (isLoading) {
      return <p>Loading ...</p>;
    }

    return (
          <BrowserRouter>
            <Switch>
              <Route exact path="/home" component={HomePage}/>
              <Route path="/about-us" component={AboutUs}/>
              <Route path="/contact-us" component={ContactUs}/>
              <Route path="/site-map" component={SiteMapPage}/>
              <Route path="/feedback" component={FeedbackPage}/>
              <Route path="/signon" component={SignonPage}/>
              <Route path="/landing" component={LandingPage}/>
              <Route path="/" component={ErrorPage}/>
            </Switch>
          </BrowserRouter>
    );
  }
}
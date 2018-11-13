import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';

import './include/bootstrap';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { AppNav } from './Components/AppNav';
import {newReimbursementComponent} from './Components/newReimbursementComponent';
import { homeComponent } from './Components/homeComponent';
import {viewReimbursementComponent} from './Components/viewReimbursementComponent';
import {viewMyReimbursementComponent} from './Components/viewMyReimbursementComponent';
import {signInComponent} from './Components/signInComponent';


class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <>
          <AppNav />
          <div id="main_content_containter">
          <Switch>
            <Route path="/home" component={homeComponent} />
            <Route path="/sign-in" component={signInComponent} />
            <Route path="/newReimb" component={newReimbursementComponent} />
            <Route path="/viewReimb" component={viewReimbursementComponent} />
            <Route path="/myReimb" component={viewMyReimbursementComponent} /> 
            {/* /myReimb does not have a navbar listing because it will be accessed within the viewReimb page */}
          </Switch>
          </div>
        </>
      </BrowserRouter>
    );
  }
}

export default App;

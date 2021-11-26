import './App.css';
import React from 'react';
import {
  BrowserRouter,
  Switch,
  Route,

} from "react-router-dom";
import AllDiscs from './components/AllDiscs';
import HomePage from './components/Home';
import AllBags from './components/AllBags';
import OneBag from './components/OneBag';
import AddDiscsToBag from './components/AddDiscToBag';
import AddABag from './components/AddABag';



function App() {
  return (

    <BrowserRouter>
      <div className="App">
        <Switch>
          <Route  exact path = '/'>
            <HomePage  />
          </Route>
          <Route  exact path = '/allDiscs'>
            <AllDiscs  />
          </Route>
          <Route  exact path = '/allBags'>
            <AllBags  />
          </Route>
          <Route  exact path = '/AddABag'>
            <AddABag  />
          </Route>
          <Route  exact path = '/oneBag/:id'>
            <OneBag  />
          </Route>
          <Route  exact path = '/oneBag/:id/discs'>
            <AddDiscsToBag  />
          </Route>
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;

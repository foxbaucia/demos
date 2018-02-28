import React from "react";

import Filters from "./Filters";
import List from "./List";

export default class Layout extends React.Component {
  constructor() {
    super();
    this.state = {
      titles : ["Url", "Hits"],
      filters : {
        autorefresh: true,
        size: 3  
      },
      data: []
    };
  }

  handleAutorefresh (autorefresh) {
    const _state = this.state;
    _state.filters.autorefresh = autorefresh;
    this.setState(_state);
  }

  handleChangeSize(size) {
    const _state = this.state;
    _state.filters.size = size;
    this.setState(_state);
  }

  handleRefreshData() {
    const _state = this.state;
    this.setState(_state);
  }

  render() {
    return (
      <div>
        <div class="row">
          <Filters 
            onChange={() => this.handleRefreshData()} 
            filters={this.state.filters} 
            onChangeSize={(size) => this.handleChangeSize(size)}
            onAutorefresh={(autorefresh) => this.handleAutorefresh(autorefresh)}
           />
        </div>
        <div class="row">
          <List filters={this.state.filters} titles={this.state.titles}/>
        </div>
      </div>
    );
  }
}
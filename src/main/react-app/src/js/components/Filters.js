import React from "react";
import Reload from "./Filters/Reload";
import Size from "./Filters/Size";
import Autorefresh from "./Filters/Autorefresh";


export default class Filters extends React.Component {
  render() {
    return (
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading" data-toggle="collapse" data-target="#filter-body">
                    <i class="fa fa-filter fa-fw"></i>Filters 
                </div>
                <div class="panel-body collapse in" id="filter-body">
                    <div class="row">
                      <Autorefresh onChange={(size) => this.props.onAutorefresh(size)} value={this.props.filters.autorefresh} />
                    </div>
                    <div class="row">
                      <Size onChange={(size) => this.props.onChangeSize(size)} value={this.props.filters.size} />
                    </div>
                    <div class="row">
                      <Reload onClick={() => this.props.onChange()} />
                    </div>
                </div>
            </div>
        </div>

    );
  }
}
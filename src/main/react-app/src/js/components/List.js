import React from "react";
import ListTitle from "./List/ListTitle";
import Row from "./List/Row";


export default class List extends React.Component {
  

  constructor(props) {
    super(props);
    this.state = {
      filters: props.filters,
      titles: props.titles,
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidMount() {
    this.getData();
  }
  componentWillReceiveProps() {
    this.getData();
  }

  componentWillUnmount () {
    clearTimeout(this.timeout);
  }

  render() {
    const { error, isLoaded, items } = this.state;
    if (error) {
      return (<div class="alert alert-danger fade in alert-dismissible">
          <strong>Error:</strong> {error.message}
      </div>)


    } else if (!isLoaded) {
      return (
          <div class="alert alert-info fade in alert-dismissible">
              <strong>Loading...</strong>
          </div>
        )
    } else {
      return (
        this.buildTable(items)
      );
    }
  }

  buildTable(items) {
    if (items.length == 0) {
        return (
          <div class="alert alert-warning fade in alert-dismissible">
              <strong>No Data</strong>
          </div>
        )

    }
    return (
      <div>
        <div class="col-lg-12">
          <div class="panel panel-default">
            <div class="panel-heading">
                Urls Data
            </div>
            <div class="panel-body">
              <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                <ListTitle titles={this.state.titles}/>
                <tbody>
                  {items.map((item, index) => (
                    <Row item={item} index={index} key={index}/>
                  ))}
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>      

    )
  }

  componentDidUpdate() {
    /*
    <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Bar Chart
                </div>
                <div class="panel-body">
                    <div id="morris-bar-chart"></div>
                </div>
            </div>
        </div>      

    if (Array.isArray(this.state.items) && this.state.items.length > 0 ) {
      // init the char
      const _data = this.state.items;
      var _chartData = [];
      for (var i = 0; i < _data.length; i ++) {
        _chartData.push ({
          label: _data[i].name,
          value: _data[i].hits
        })
      }

      Morris.Donut({
        element: 'morris-bar-chart',
        data: _data
      });
    }
    */
  }

  getData() {
    const url = 'http://localhost:8081/api/v1/domains/?size=' + this.state.filters.size;
    fetch(url, {
	   method: 'get', 
	   headers: {
	   	 'Access-Control-Allow-Headers': '*',
	     // 'Authorization': 'Basic '+btoa('username:password'), 
	     'Content-Type': 'application/json'
	   }, 

      })
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result
          });
          if (this.state.filters.autorefresh) {
            this.timeout = setTimeout(this.getData.bind(this), 3000);
          }
        },
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )

    var xhr = new XMLHttpRequest()

   }

}

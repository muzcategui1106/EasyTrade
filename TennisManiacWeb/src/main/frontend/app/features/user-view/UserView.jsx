var converter = new Showdown.converter();

var User = React.createClass({
    displayName: "User",
    render: function () {
        return (
            React.createElement("div", {className: "user"},
                React.createElement("h2", null, this.props.firstName.concat(" ", this.props.lastName))
            )
        );
    }
});

var UserList = React.createClass({
    displayName: "UserList",
    render: function () {
        var UserNodes = this.props.data.map(function (user, index) {
            return (
                React.createElement(User, {firstName: user.firstName, lastName: user.lastName, key: index}
                )
            );
        });
        return (
            React.createElement("div", {className: "userList"},
                UserNodes
            )
        );
    }
});

var UserBox = React.createClass({
    displayName: "UserBox",
    loadUsersFromServer: function () {
        axios.get(this.props.url, {})
            .then(function (response) {
                this.setState({data: data});
            })
            .catch(function (error) {
                console.log(error);
            });
    },
    getInitialState: function () {
        return {data: this.props.data};
    },
    componentWillMount: function () {
        this.loadUsersFromServer();
    },
    componentDidMount: function () {
        this.loadUsersFromServer();
        setInterval(this.loadUsersFromServer, this.props.pollInterval);
    },
    render: function () {
        this.loadUsersFromServer();
        return (
            React.createElement("div", {className: "UserBox"},
                React.createElement("h1", null, "User"),
                React.createElement(UserList, {data: this.state.data})
            )
        );
    }
});
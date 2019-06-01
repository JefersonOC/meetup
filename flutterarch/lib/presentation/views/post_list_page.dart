import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

import 'package:flutter_architecture/presentation/model/model.dart';
import 'package:flutter_architecture/presentation/bloc/postlist/postlist.dart';

class PostListPage extends StatefulWidget {

    PostListPage({Key key, this.title}) : super(key: key);

    final String title;

    @override
    _PostListPageState createState() => new _PostListPageState();
}

class _PostListPageState extends State<PostListPage> {

    final TextStyle _biggerFont = const TextStyle(fontSize: 18.0);
    final PostBloc _postBloc = PostBloc();

    @override
    void initState() {
        super.initState();
        _postBloc.dispatch(Fetch());
    }

    @override
    Widget build(BuildContext context) {
        return new Scaffold(
            appBar: new AppBar(
                title: new Text(widget.title),
            ),
            body: _buildListView()
        );
    }

    Widget _buildListView() {
        return BlocBuilder(
            bloc: _postBloc,
            builder: (BuildContext context, PostState state){
                if(state is PostUninitialized){
                    return new Center(
                        child: CircularProgressIndicator()
                    );
                }

                if(state is PostLoaded){
                    return new Center(
                            child: new ListView.builder(
                            padding: const EdgeInsets.all(16.0),
                            itemCount: state.posts.length,
                            itemBuilder: (BuildContext _context, int i) {
                                return _buildRow(i, state.posts[i]);
                            }
                        )
                    );
                }

                if(state is PostError){
                    return new Center(
                        child: Text('failed to fetch posts')
                    );
                }
            }
        );
    }

    Widget _buildRow(int index, Post post) {
        return new ListTile(
            title: new Text(
                "$index. ${post.title}",
                style: _biggerFont,
            )
        );
    }
}
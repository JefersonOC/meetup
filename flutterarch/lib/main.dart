import 'package:flutter/material.dart';
import 'package:flutter_architecture/presentation/views/post_list_page.dart';

void main() => runApp(new MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'Flutter Demo',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new PostListPage(title: 'Flutter Demo Home Page'),
    );
  }
}


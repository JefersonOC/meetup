class RemotePost {
  
  int userId;
  
  int id;
  
  String title;
  
  String body;

  RemotePost.fromMap(dynamic json) :
        userId = json['userId'],
        id = json['id'],
        title = json['title'],
        body = json['body'];
}
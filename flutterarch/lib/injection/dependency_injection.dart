import 'package:flutter_architecture/framework/http/client.dart';
import 'package:flutter/services.dart';

import 'package:flutter_architecture/data/repository/repository.dart';
import 'package:flutter_architecture/data/datasource/datasource.dart';

enum Flavor {
  MOCK,
  PROD,
  STAGE
}

class Injector {

  static final Injector _singleton = new Injector._internal();

  static Flavor _flavor;

  static void configure(Flavor flavor) {
    _flavor = flavor;
  }

  static Flavor getFlavor() {
    return _flavor;
  }

  factory Injector() {
    return _singleton;
  }

  static PostRepository providePostRepository({Client client}) {
    switch (_flavor) {
      case Flavor.MOCK:
        return new PostRepositoryImpl(
            new RemoteDataSource(client: client));
      case Flavor.PROD:
        return new PostRepositoryImpl(
            new RemoteDataSource(client: client));
      case Flavor.STAGE:
        return new PostRepositoryImpl(
            new RemoteDataSource(client: client));
      default:
        return new PostRepositoryImpl(
            new RemoteDataSource(client: client));
    }
  }

  Injector._internal();
}
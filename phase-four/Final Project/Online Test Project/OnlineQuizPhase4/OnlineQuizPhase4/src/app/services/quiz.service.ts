import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  constructor(private http: HttpClient) {}

  get(url: string) {
    return this.http.get(url);
  }

  getAll() {
    return [
      {
        id: 'data/javascript.json',
        name: 'JavaScript(Js)',
        description:
        " We have created a Free JavaScript(Js) online test that will help you enhance your basic knowledge of Js.This JavaScript(Js)mock test contains 10 JavaScript(Js) quiz questions and answers with 1 mark each. You can select only 1 answer from the given options. Complete this free online JavaScript(Js) quiz questions for practice.",
        imageUrl: 'assets/images/JS.png',
      },
      {
        id: 'data/aspnet.json',
        name: 'Asp.Net',
        description:
          " We have created a Free ASP.NET online test that will help you enhance your basic knowledge of ASP.NET.This ASP.NET mock test contains 10 ASP.NET quiz questions and answers with 1 mark each. You can select only 1 answer from the given options. Complete this free online ASP.NET quiz questions for practice.",
        imageUrl: 'assets/images/ASP.png',
      },
      
      {
        id: 'data/csharp.json',
        name: 'C Sharp(C#)',
        description:
          " We have created a Free C Sharp (C#) online test that will help you enhance your basic knowledge of C#.This C Sharp(C#) mock test contains 10 C Sharp(C#) quiz questions and answers with 1 mark each. You can select only 1 answer from the given options. Complete this free online C Sharp(C#) quiz questions for practice.",
        imageUrl: 'assets/images/CSHARP.png',
      },
    ];
  }
}

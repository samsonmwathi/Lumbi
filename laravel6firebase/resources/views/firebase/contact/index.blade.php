@extends('firebase.app')


@section('content')
<div class="container">
    <div class="row">
        <div class="col-md-12">
            @if(session('status'))
                    <h4 class="alert alert-warning mb-2">{{session('status')}}</h4>
            @endif

            <div class="card">
                <div class="card-header">
                    <h4>Contact List Total: {{$total_contacts}} 
                        <a href="{{url('add-contact')}}" class="btn btn-sm btn-primary float-end">Add Contact</a>
                    </h4>
                </div>
                <div class="card-body">
                    <table class="table table-bordered">
                         <thead>
                            <tr>
                                <th>id</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>Email</th>
                                <th>phone</th>
                                <th>edit</th>
                                <th>delete</th>
                            </tr>
                         </thead>
                         <tbody>
                         @php $i = 1;@endphp
                         @forelse ($contacts as $key => $item)
                            <tr>
                                <td>{{$i++}}</td> 
                                <td>{{$item['fname']}}</td> 
                                <td>{{$item['lname']}}</td> 
                                <td>{{$item['email']}}</td> 
                                <td>{{$item['phone']}}</td> 
                                <td>
                                    <a href="{{url('edit-contact/'.$key)}}"class="btn btn-sm btn-success">Edit</a>
                                </td>  
                                <td>
                                    <!-- <a href="{{url('delete-contact/'.$key)}}"class="btn btn-sm btn-danger">Delete</a> -->
                                    <form action="{{url('delete-contact/'.$key)}}" method="POST">
                                        @csrf
                                        @method('DELETE')
                                        <button type ='submit' class="btn btn-sm btn-danger">Delete</button>
                                    </form>
                                </td>         
                            </tr>
                         @empty
                            <tr>
                                <td colspan="/">No Record Found</td>            
                            </tr>
                         @endforelse
                           
                         </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


@endsection

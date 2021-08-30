<?php

namespace App\Http\Controllers\Firebase;

use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use Kreait\Firebase\Database;

class ContactController extends Controller
{
    public function __construct(Database $database)
    {
        $this->database = $database;
        $this->tablename='contacts';
    }
    public function index(){

        $contacts = $this->database->getReference($this->tablename)->getValue();
        $total_contacts = $reference = $this->database->getReference($this->tablename)->getSnapshot()->numChildren();
        return view('firebase.contact.index',compact('contacts','total_contacts'));
    }
    public function create(){
        return view('firebase.contact.create');
    }
    public function store(Request $request){
        $ref_tablename='contacts';
        $postData = [
            'fname' => $request->first_name,
            'lname' => $request->last_name,
            'phone' => $request->phone,
            'email' => $request->email,
        ];
        $postRef = $this->database->getReference($this->tablename)->push($postData);
        if($postRef){
            return redirect('contacts')->with('status','contact added successfully');
        }
        else{
            return redirect('contacts')->with('status','contact not added ');
        }
    }
    public function edit($id){
        $key=$id;
        $editdata = $this->database->getReference($this->tablename)->getChild($key)->getvalue();
        if($editdata){
            return view('firebase.contact.edit', compact('editdata','key'));
        }else{
            return redirect('contacts')->with('status','Contact ID Not Found ');
        };
        
    }
    public function update(Request $request,$id){
        $key = $id;
        $updateData = [
            'fname' => $request->first_name,
            'lname' => $request->last_name,
            'phone' => $request->phone,
            'email' => $request->email,
        ];
        $res_updated=$this->database->getReference($this->tablename.'/'.$key)->update($updateData);
        if($res_updated){
            return redirect('contacts')->with('status','Contact Updated Successfully ');
        }
        else{
            return redirect('contacts')->with('status','Contact Not Successfully ');
        }
    }
    public function destroy($id){
        $key = $id;
        $del_data = $this->database->getReference($this->tablename.'/'.$key)->remove();
        if($del_data){
            return redirect('contacts')->with('status','Contact Deleted Successfully ');
        }
        else{
            return redirect('contacts')->with('status','Contact Not Deleted Successfully ');
        }
    }
}

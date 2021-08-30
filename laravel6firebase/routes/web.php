<?php

use App\Http\Controllers\firebase\ContactController;
/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/
Route::get('contacts',[ContactController::class,'index']);
Route::get('add-contact',[ContactController::class,'create']);
Route::post('add-contact',[ContactController::class,'store']);
Route::get('edit-contact/{id}',[ContactController::class,'edit']);
Route::put('update-contact/{id}',[ContactController::class,'update']);
// Route::get('delete-contact/{id}',[ContactController::class,'destroy']);
Route::delete('delete-contact/{id}',[ContactController::class,'destroy']);
Route::get('/', function () {
    return view('welcome');
});

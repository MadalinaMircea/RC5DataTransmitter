class Information(var path: String, var contents: String) {

    public fun GetHashmap() : HashMap<String, String>
    {
        val map: HashMap<String, String> = hashMapOf("Path" to path, "Contents" to contents)
        return map
    }

    public fun GetJson() : String
    {
        return "{\"path\": \"" + path + "\",\"contents\": \"" + contents + "\"}"
    }
}
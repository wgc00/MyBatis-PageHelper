# MyBatis-PageHelper
分页

       /*查询的方法*/
    @RequestMapping(value = "query", method = RequestMethod.GET)
    public String home(@RequestParam(defaultValue = "1") int page, Model model) {
        //ModelAndView mv = new ModelAndView("home");
        PageHelper.startPage(page, 2);
        List<Directories> directoriesList = directories.selectAll();
        model.addAttribute("directoriesList", directoriesList);
        model.addAttribute("pageInfo", new PageInfo<>(directoriesList));
        //返回给jsp
        return "home";
    }
